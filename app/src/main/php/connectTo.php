<?php
$param = $_GET['param'];
$str = $_GET['str'];
//$uri = 'http://api.football-data.org/v2/competitions/EC/teams';
//$uri = 'http://api.football-data.org/v2/competitions/EC';
//$uri = 'http://api.football-data.org/v2/teams/759'; <---------------------
//$uri = 'http://api.football-data.org/v2/competitions/2000/teams';
//$uri = 'http://api.football-data.org/v2/competitions';

$uri = 'http://api.football-data.org/v2/'.$param;
$reqPrefs['http']['method'] = 'GET';
$reqPrefs['http']['header'] = 'X-Auth-Token: c1fced87b9624809b2b3b35ac9eed8d5';
$stream_context = stream_context_create($reqPrefs);
$response = file_get_contents($uri, true, $stream_context);

if ($str == '0'){
    $f = fopen('str0.txt', 'r+'); // Открываем файл
    fwrite($f, $response); // Записываем данные
    fclose($f); // Закрываем файл
}
if ($str == '1'){
    $f = fopen('str1.txt', 'r+'); // Открываем файл
    fwrite($f, $response); // Записываем данные
    fclose($f); // Закрываем файл
}
if ($str == '2'){
    $f = fopen('str2.txt', 'r+'); // Открываем файл
    fwrite($f, $response); // Записываем данные
    fclose($f); // Закрываем файл
}
if ($str == '3'){
    $f = fopen('str3.txt', 'r+'); // Открываем файл
    fwrite($f, $response); // Записываем данные
    fclose($f); // Закрываем файл
}


echo $response;
return $response;
