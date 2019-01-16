<?php
use Minter\MinterAPI;
use GuzzleHttp\Exception\RequestException;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

try {
    $limit = 10; // optional, should be positive integer or null
    $response = $api->getUnconfirmedTxs($limit);
    print_r($response);
} catch(RequestException $exception) {
    // handle error
}
