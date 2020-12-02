import java.util.*;

class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        List<Transaction> allTransactions = new ArrayList<>();
        for(String x : transactions){
            allTransactions.add(new Transaction(x));
        }
        for(int i = 0; i < transactions.length; i++){
            for(int j = 0; j < transactions.length; j++){
                if(i == j) continue;
                if(allTransactions.get(i).name.equals(allTransactions.get(j).name) && !allTransactions.get(i).city.equals(allTransactions.get(j).city) && Math.abs(allTransactions.get(i).time - allTransactions.get(j).time) <= 60){
                    if(!invalid.contains(allTransactions.get(i).toString())){
                        invalid.add(allTransactions.get(i).toString());
                    }
                } else if(allTransactions.get(i).amount >= 1000){
                    if(!invalid.contains(allTransactions.get(i).toString())){
                        invalid.add(allTransactions.get(i).toString());
                    }
                }
            }
        }
        return invalid;
    }
}

class Transaction {
    String name;
    int time;
    int amount;
    String city;

    public Transaction(String myTransaction){
        String[] splitTrans = myTransaction.split(",");
        name = splitTrans[0];
        time = Integer.parseInt(splitTrans[1]);
        amount = Integer.parseInt(splitTrans[2]);
        city = splitTrans[3];
    }

    @Override
    public String toString(){
        return name+','+time+','+amount+','+city;
    }
}