<?php
require "connect.php";
class ChuDe
{
    function ChuDe($idchude, $tenchude, $hinhnen)
    {
        $this->IDChuDe = $idchude;
        $this->TenChuDe = $tenchude;
        $this->HinhNen = $hinhnen;
    }
}

class TheLoai
{
    function TheLoai($idtheloai, $idchude, $tentheloai, $hinhnen)
    {
        $this->IDTheLoai = $idtheloai;
        $this->IDChuDe = $idchude;
        $this->TenTheLoai = $tentheloai;
        $this->HinhNen = $hinhnen;
    }
}

$query_chude = "SELECT DISTINCT * FROM CHUDE ORDER BY rand(" . date("Ymd") . ") LIMIT 2";
$query_theloai = "SELECT DISTINCT * FROM THELOAI ORDER BY rand(" . date("Ymd") . ") LIMIT 2";
$data_chude = mysqli_query($con, $query_chude);
$data_theloai = mysqli_query($con, $query_theloai);

$array_chude = array();
$array_theloai = array();
while ($row = mysqli_fetch_assoc($data_chude)) {
    array_push($array_chude, new ChuDe($row['IDChuDe'], $row['TenChuDe'], $row['HinhNen']));
}

while ($row = mysqli_fetch_assoc($data_theloai)) {
    array_push($array_theloai, new TheLoai($row['IDTheLoai'], $row['IDChuDe'], $row['TenTheLoai'], $row['HinhNen']));
}

$result = array(
    'TheLoai' => $array_theloai,
    'ChuDe' => $array_chude
);

echo json_encode($result);
