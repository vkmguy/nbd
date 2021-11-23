var mapCredit = function(){
  for(i=0;i<this.credit.length;i++){
      var cred = this.credit[i];
      emit(cred.currency, parseFloat(cred.balance));
  }
}

var reduceCredit = function(currency, balances){
  sum = 0.0;
  for(i=0;i<balances.length;i++){
      sum += balances[i];
  }
  return sum;
}

db.people.mapReduce(
mapCredit,
reduceCredit,
{out: 'sum_credits_by_currency'}
)
printjson(db.sum_credits_by_currency.find().toArray())