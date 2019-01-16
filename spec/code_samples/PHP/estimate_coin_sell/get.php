<?php
use Minter\MinterAPI;
use GuzzleHttp\Exception\RequestException;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

try {
    $coinToSell = 'MNT';
    $coinToBuy = 'TESTCOIN';
    $valueToSell = '10.5';

    $response = $api->estimateCoinSell($coinToSell, $valueToSell, $coinToBuy);
    print_r($response);
} catch(RequestException $exception) {
    // handle error
}
