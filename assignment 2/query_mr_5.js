var mapPolishWomenCurrency = function(){
  for(i=0;i<this.credit.length;i++){
      var cred = this.credit[i];
      if(this.nationality == "Poland" && this.sex == "Female"){
        emit(cred.currency, parseFloat(cred.balance));
      }
  }
};

var reducePolishWomenCurrency = function(currency, values){
  var reduceValues = {count: 0, sumMoney: 0.0};
  for(i=0;i<values.length;i++){
      reduceValues.count += 1;
      reduceValues.sumMoney += values[i];
  }
  return reduceValues;
};

function finalizePolishWomenCurrency(currency, values) {
   averageMoney = values.sumMoney/values.count;
   totalMoney = values.sumMoney;
   return {averageMoney, totalMoney};
};

db.people.mapReduce(
mapPolishWomenCurrency,
reducePolishWomenCurrency,
{
  out: 'money_avg_sum_by_nationality_women',
  finalize: finalizePolishWomenCurrency
}
)

printjson(db.money_avg_sum_by_nationality_women.find().toArray())