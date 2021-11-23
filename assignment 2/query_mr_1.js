var mapSex = function(){
  var key = this.sex;
  var value = { count: 1, height: parseFloat(this.height), weight: parseFloat(this.weight)};
  emit(key, value);
};

var reduceSex = function(sex, values){
  var reduceValues = {count: 0, weight: 0.0, height: 0.0};
  for(i=0;i<values.length;i++){
      reduceValues.count += values[i].count;
      reduceValues.height += values[i].height;
      reduceValues.weight += values[i].weight;
  }
  return reduceValues;
};

function finalizeSex(sex, value) {
   averageHeight = value.height/value.count;
   averageWeight = value.weight/value.count;
   return {averageWeight, averageHeight};
};

db.people.mapReduce(
mapSex,
reduceSex,
{
  out: 'avg_weight_height_by_gender',
  finalize: finalizeSex
}
)

printjson(db.avg_weight_height_by_gender.find().toArray())