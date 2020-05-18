<?php
require "connect.php";
class BaiHat
{
    function BaiHat($idbaihat, $tenbaihat, $casi, $hinhanh , $linkbaihat, $luotnghe)
    {
        $this->IDBaiHat = $idbaihat;
        $this->TenBaiHat = $tenbaihat;
        $this->CaSi = $casi;
        $this->HinhAnh = $hinhanh;
        $this->LinkBaiHat = $linkbaihat;
        $this->LuotNghe = $luotnghe;
    }
}

if(isset($_POST['IDBaiHat'])){
    $idbaihat = $_POST['IDBaiHat'];
    $query = "SELECT * FROM BAIHAT WHERE IDBaiHat = '$idbaihat'";
}

$data = mysqli_query($con, $query);

$mangbaihat = array();

while ($row = mysqli_fetch_assoc($data)) {
    array_push($mangbaihat, new BaiHat($row['IDBaiHat'], $row['TenBaiHat'], $row['CaSi']
                                        , $row['HinhBaiHat'], $row['LinkBaiHat'], $row['LuotNghe']));
}

echo json_encode($mangbaihat);
