<?php
require "connect.php";
class QuangCao{
    function QuangCao($idquangcao, $hinhanh, $noidung, $idbaihat, $tenbaihat, $hinhbaihat){
        $this->IDQuangCao = $idquangcao;
        $this->HinhAnh = $hinhanh;
        $this->NoiDung = $noidung;
        $this->IDBaiHat = $idbaihat;
        $this->TenBaiHat = $tenbaihat;
        $this->HinhBaiHat = $hinhbaihat;
    }
}

$query = "SELECT quangcao.IDQuangCao, quangcao.HinhAnh, quangcao.NoiDung, quangcao.IDBaiHat, baihat.TenBaiHat, baihat.HinhBaiHat
FROM QUANGCAO quangcao, BAIHAT baihat
WHERE quangcao.IDBaiHat = baihat.IDBaiHat";

$data = mysqli_query($con, $query);
$mangquangcao = array();

while($row = mysqli_fetch_assoc($data)){
    array_push($mangquangcao, new QuangCao($row['IDQuangCao'], $row['HinhAnh'], $row['NoiDung']
                                            ,$row['IDBaiHat'], $row['TenBaiHat'], $row['HinhBaiHat']));
}

echo json_encode($mangquangcao);

