<?php
use Minter\MinterAPI;

$api = new MinterAPI('https://minter-node-1.testnet.minter.network:8841');

print_r($api->getStatus());
