var mapBmi = function(){
  var key = this.nationality;
  var value = { bmi: parseFloat(this.weight) / (parseFloat(this.height) * parseFloat(this.height))};
  emit(key, value);
};

var reduceBmi = function(nationality, values){
  var reduceValues = {count: 0, sumBmi: 0.0, minBmi: Number.MAX_VALUE, maxBmi: Number.MIN_VALUE};
  for(i=0;i<values.length;i++){
      reduceValues.count += 1;
      reduceValues.sumBmi += values[i].bmi;
      reduceValues.maxBmi = Math.max(values[i].bmi, reduceValues.maxBmi);
      reduceValues.minBmi = Math.min(values[i].bmi, reduceValues.minBmi);
  }
  return reduceValues;
};

function finalizeBmi(nationality, value) {
   maxBmi = value.maxBmi;
   minBmi = value.minBmi;
   averageBmi = value.sumBmi/value.count;
   return {averageBmi, maxBmi, minBmi};
};

db.people.mapReduce(
mapBmi,
reduceBmi,
{
  out: 'bmi_avg_min_max_by_nationality',
  finalize: finalizeBmi
}
)

printjson(db.bmi_avg_min_max_by_nationality.find().toArray())