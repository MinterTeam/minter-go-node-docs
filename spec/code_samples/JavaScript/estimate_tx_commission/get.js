import {Minter, SendTxParams, API_TYPE_NODE} from "minter-js-sdk";

const minterSDK = new Minter({apiType: API_TYPE_NODE, baseURL: 'https://minter-node-1.testnet.minter.network:8841'});
const rawTx = 'f8911a018a4d4e540000000000000001aae98a4d4e5400000000000000947633980c000139dd3bd24a3f54e06474fa941e16888ac7230489e800008e637573746f6d206d6573736167658001b845f8431ca0c0716faaac63263c8c6106fa17f863eec2de60431214dd8d775147d4ed972410a05f881fb3938acf69a0a7eb761e5479fbbd60780e1db0c85a0670150eb7b070ab';

minterSDK.estimateTxCommission({
        transaction: rawTx,
    })
    .then((commission) => {
        console.log(commission);
    })
    .catch((error) => {
        const errorMessage = error.response.data.error.message;
        console.log(errorMessage);
    });


