import {Minter, SendTxParams, API_TYPE_NODE} from "minter-js-sdk";

const minterSDK = new Minter({apiType: API_TYPE_NODE, baseURL: 'https://minter-node-1.testnet.minter.network:8841'});
const txParams = new SendTxParams({
    privateKey: '5fa3a8b186f6cc2d748ee2d8c0eb7a905a7b73de0f2c34c5e7857c3b46f187da',
    address: 'Mx7633980c000139dd3bd24a3f54e06474fa941e16',
    amount: 10,
    coinSymbol: 'MNT',
    feeCoinSymbol: 'ASD',
    message: 'custom message',
});

minterSDK.postTx(txParams)
    .then((txHash) => {
        console.log(`Tx created: ${txHash}`);
    })
    .catch((error) => {
        const errorMessage = error.response.data.error.message;
        console.log(errorMessage);
    });
