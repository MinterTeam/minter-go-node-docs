<?php
use Minter\MinterAPI;
use GuzzleHttp\Exception\RequestException;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

try {
    $publicKey = 'Mpb52951425d2517504f767215ca77a9be3e0cd788fd72443da9b174fc686a37f0';
    $response = $api->getCandidate($publicKey);
    print_r($response);
} catch(RequestException $exception) {
    
}
