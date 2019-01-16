<?php
use Minter\MinterAPI;
use GuzzleHttp\Exception\RequestException;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

try {
	$height = 1;
    $response = $api->getBlock($height);
    print_r($response);
} catch(RequestException $exception) {
    // handle error
}
