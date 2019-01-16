<?php
use Minter\MinterAPI;
use GuzzleHttp\Exception\RequestException;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

try {
    $coinToSell = 'TESTCOIN';
    $coinToBuy = 'MNT';
    $valueToBuy = '10.5';

    $response = $api->estimateCoinBuy($coinToSell, $valueToBuy, $coinToBuy);
    print_r($response);
} catch(RequestException $exception) {
    
}
