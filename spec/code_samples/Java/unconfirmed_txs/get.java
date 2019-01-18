MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainTransactionRepository repository = MinterBlockChainApi.getInstance().transactions();

Call<BCResult<UnconfirmedTransactions>> request = repository.getUnconfirmedList();

request.enqueue(new Callback<BCResult<UnconfirmedTransactions>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<UnconfirmedTransactions>> call, @Nonnull Response<BCResult<UnconfirmedTransactions>> response) {
        BCResult<UnconfirmedTransactions> body = response.body();
        if (body.isOk()) {
            /*
            for(TransactionSign sign: body.result) {
                // do smthng with sign
            }
            */
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<UnconfirmedTransactions>> call, @Nonnull Throwable t) {
        // handle error
    }
});
