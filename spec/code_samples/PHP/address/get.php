<?php
use Minter\MinterAPI;
use GuzzleHttp\Exception\RequestException;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

// to get full balance
try {
    $response = $api->getBalance('Mx618ed05277e7568ee943cd1b8e22ced4cf873f95');
    print_r($response);
} catch(RequestException $exception) {
    
}

// to get nonce of address
try {
    $response = $api->getNonce('Mx618ed05277e7568ee943cd1b8e22ced4cf873f95');
    print_r($response);
} catch(RequestException $exception) {
    
}
