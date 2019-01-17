import {Minter, SendTxParams, API_TYPE_NODE} from "minter-js-sdk";

const minterSDK = new Minter({apiType: API_TYPE_NODE, baseURL: 'https://minter-node-1.testnet.minter.network:8841'});

minterSDK.estimateCoinSell({
        coinToSell: 'MNT',
        valueToSell: 1,
        coinToBuy: 'ASDCOIN',
    })
    .then((estimateResult) => {
        console.log(estimateResult.will_get);
        console.log(estimateResult.commission);
    })
    .catch((error) => {
        const errorMessage = error.response.data.error.message;
        console.log(errorMessage);
    });
