<?php
require 'connect.php';

$searchResults = array();

if (isset($_GET["keyword"]) && isset($_GET["type"])) {
	$keyword = $_GET["keyword"];
	$type = $_GET["type"];

	switch ($type) {
		case 'album':
			$searchResults = array_merge($searchResults, SearchTempate(
				$keyword, 
				"SELECT ALBUM.*, COUNT(BAIHAT.IDBaiHat) AS 'sobaihat' FROM ALBUM JOIN BAIHAT ON BAIHAT.IDAlbum = ALBUM.IDAlbum WHERE ALBUM.TenAlbum LIKE '%$keyword%' GROUP BY ALBUM.IDAlbum", 
				"convertArrayToAlbum"
			));
			break;

		case 'chude':
			$searchResults = array_merge($searchResults, SearchTempate(
				$keyword, 
				"SELECT CHUDE.*, COUNT(BAIHAT.IDBaiHat) AS 'sobaihat' FROM CHUDE JOIN THELOAI ON THELOAI.IDChuDe = CHUDE.IDChuDe JOIN BAIHAT ON BAIHAT.IDTheLoai = THELOAI.IDTheLoai WHERE CHUDE.TenChuDe LIKE '%$keyword%' GROUP BY CHUDE.IDChuDe", 
				"convertArrayToChuDe"
			));
			break;

		case 'nghesi':
			$searchResults = array_merge($searchResults, SearchTempate(
				$keyword, 
				"SELECT BAIHAT.CaSi AS 'name', COUNT(BAIHAT.IDBaiHat) AS 'sobaihat', COUNT(ALBUM.IDAlbum) AS 'soalbum', COUNT(THELOAI.IDTheLoai) AS 'sotheloai', SUM(BAIHAT.LuotNghe) AS 'soluotnghe', COUNT(CHUDE.IDChuDe) AS 'sochude' FROM BAIHAT JOIN ALBUM ON ALBUM.IDAlbum = BAIHAT.IDAlbum JOIN THELOAI ON THELOAI.IDTheLoai = BAIHAT.IDTheLoai JOIN CHUDE ON CHUDE.IDChuDe = THELOAI.IDChuDe WHERE BAIHAT.CaSi LIKE '%$keyword%' GROUP BY BAIHAT.CaSi ", 
				"convertArrayToCaSi"
			));
			break;

		case 'song':
			//
			break;

		case 'theloai':
			//
			break;
		
		default:
			break;
	}
}

function SearchTempate($keyword, $query, $convertArrayToObject)
{
	global $con;
	$searchResults = array();

	$queryResults = mysqli_query($con, $query);

	if ($queryResults == false) {
		print_r(mysqli_error($con));
		return;
	}

	while (true) {
		$queryResult = mysqli_fetch_assoc($queryResults);

		if (gettype($queryResult) != "array") {
			break;
		}

	    $object = $convertArrayToObject($queryResult);
	    array_push($searchResults, $object);
	}

	return $searchResults;
}

function convertArrayToAlbum($queryResult)
{
	return (object) [
		"id" => $queryResult["IDAlbum"], 
		"name" => $queryResult["TenAlbum"], 
		"casi" => $queryResult["CaSi"], 
		"hinhnen" => $queryResult["HinhNen"], 
		"sobaihat" => $queryResult["sobaihat"]
	];
}

function convertArrayToChuDe($queryResult)
{
	return (object) [
		"id" => $queryResult["IDChuDe"], 
		"name" => $queryResult["TenChuDe"], 
		"hinhnen" => $queryResult["HinhNen"], 
		"sobaihat" => $queryResult["sobaihat"]
	];
}

function convertArrayToCaSi($queryResult)
{
	return (object) [
		"id" => "",
		"name" => $queryResult["name"],
		"sobaihat" => $queryResult["sobaihat"],
		"soalbum" => $queryResult["soalbum"],
		"sotheloai" => $queryResult["sotheloai"],
		"soluotnghe" => $queryResult["soluotnghe"],
		"sochude" => $queryResult["sochude"],
		"hinhnen" => ""
	];
}

echo json_encode($searchResults);