<?php
use Minter\MinterAPI;
use GuzzleHttp\Exception\RequestException;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

// Get balance
try {
    $response = $api->getBalance('Mx618ed05277e7568ee943cd1b8e22ced4cf873f95');
    print_r($response);
} catch(RequestException $exception) {
    // handle error
}

// Get nonce of address
try {
    $response = $api->getNonce('Mx618ed05277e7568ee943cd1b8e22ced4cf873f95');
    print_r($response);
} catch(RequestException $exception) {
    // handle error
}
