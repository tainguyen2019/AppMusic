<?php
require "connect.php";
class Playlist
{
    function Playlist($idplaylist, $tenplaylist, $hinhnen)
    {
        $this->IDPlaylist = $idplaylist;
        $this->TenPlaylist = $tenplaylist;
        $this->HinhNen = $hinhnen;
    }
}

$query = "SELECT DISTINCT * FROM PLAYLIST ORDER BY rand(" . date("Ymd") . ") LIMIT 3";

$data = mysqli_query($con, $query);
$mangplaylist = array();

while ($row = mysqli_fetch_assoc($data)) {
    array_push($mangplaylist, new Playlist($row['IDPlaylist'], $row['TenPlaylist'], $row['HinhNen']));
}

echo json_encode($mangplaylist);
