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

		case 'song':
			$searchResults = array_merge($searchResults, SearchTempate(
				$keyword, 
				"SELECT BAIHAT.* FROM BAIHAT WHERE BAIHAT.TenBaiHat LIKE '%$keyword%'", 
				"convertArrayToBaiHat"
			));
			break;

		case 'theloai':
			$searchResults = array_merge($searchResults, SearchTempate(
				$keyword, 
				"SELECT THELOAI.*, COUNT(BAIHAT.IDBaiHat) AS 'sobaihat' FROM THELOAI JOIN BAIHAT ON BAIHAT.IDTheLoai = THELOAI.IDTheLoai WHERE THELOAI.TenTheLoai LIKE '%$keyword%' GROUP BY THELOAI.IDTheLoai ", 
				"convertArrayToTheLoai"
			));
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

function convertArrayToBaiHat($queryResult)
{
	$returnObject = (object) [
		"id" =>  $queryResult["IDBaiHat"],
		"name" => $queryResult["TenBaiHat"],
		"casi" => $queryResult["CaSi"],
		"hinhanh" => $queryResult["HinhBaiHat"],
		"link" => $queryResult["LinkBaiHat"],
		"luotnghe" => $queryResult["LuotNghe"],
		"idAlbum" => $queryResult["IDAlbum"]
		//"luotnghe" => $queryResult["IDTheLoai"]
	];

	return $returnObject;
}

function convertArrayToTheLoai($queryResult)
{
	return (object) [
		"id" =>  $queryResult["IDTheLoai"],
		"ichude" => $queryResult["IDChuDe"],
		"name" => $queryResult["TenTheLoai"],
		"hinhnen" => $queryResult["HinhNen"],
		"sobaihat" => $queryResult["sobaihat"]
	];
}

echo json_encode($searchResults);