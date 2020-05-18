<?php
require "connect.php";
class Album
{
    function Album($idalbum, $tenalbum, $casi, $hinhnen)
    {
        $this->IDAlbum = $idalbum;
        $this->TenAlbum = $tenalbum;
        $this->CaSi = $casi;
        $this->HinhNen = $hinhnen;
    }
}

$query = "SELECT DISTINCT * FROM ALBUM WHERE IDAlbum > 1 ORDER BY rand(" . date("Ymd") . ") LIMIT 4";

$data = mysqli_query($con, $query);
$mangalbum = array();

while ($row = mysqli_fetch_assoc($data)) {
    array_push($mangalbum, new Album($row['IDAlbum'], $row['TenAlbum'], $row['CaSi'], $row['HinhNen']));
}

echo json_encode($mangalbum);
