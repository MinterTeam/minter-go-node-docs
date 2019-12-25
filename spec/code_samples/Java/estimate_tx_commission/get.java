MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainTransactionRepository repository = MinterBlockChainApi.getInstance().transactions();

String sign = "..."; // signed transaction hash started without 0x
Call<BCResult<TransactionCommissionValue>> request = repository.getTransactionCommission("");

request.enqueue(new Callback<BCResult<TransactionCommissionValue>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<TransactionCommissionValue>> call, @Nonnull Response<BCResult<TransactionCommissionValue>> response) {
        BCResult<TransactionCommissionValue> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<TransactionCommissionValue>> call, @Nonnull Throwable t) {
        // handle error
    }
});
