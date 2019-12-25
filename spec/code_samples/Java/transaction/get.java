MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainTransactionRepository repository = MinterBlockChainApi.getInstance().transactions();

Call<BCResult<HistoryTransaction>> request = repository.getTransaction("");

request.enqueue(new Callback<BCResult<HistoryTransaction>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<HistoryTransaction>> call, @Nonnull Response<BCResult<HistoryTransaction>> response) {
        BCResult<HistoryTransaction> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<HistoryTransaction>> call, @Nonnull Throwable t) {
        // handle error
    }
});