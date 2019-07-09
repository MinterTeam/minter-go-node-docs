<?php
use Minter\MinterAPI;
use Minter\SDK\MinterTx;
use Minter\SDK\MinterCoins\MinterSendCoinTx;
use GuzzleHttp\Exception\RequestException;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

// Construct tx
$tx = new MinterTx([
    'nonce' => $api->getNonce('sender address here'),
    'chainId' => MinterTx::TESTNET_CHAIN_ID, // or MinterTx::MAINNET_CHAIN_ID
    'gasPrice' => 1,
    'gasCoin' => 'MNT',
    'type' => MinterSendCoinTx::TYPE,
    'data' => [
        'coin' => 'MTN',
        'to' => 'receiver address here',
        'value' => '10'
    ],
    'payload' => '',
    'serviceData' => '',
    'signatureType' => MinterTx::SIGNATURE_SINGLE_TYPE
]);

// Sign tx
$tx = $tx->sign('your private key');

try {
    $response = $api->send($tx);
    print_r($response);
} catch(RequestException $exception) {
    // handle error
}
