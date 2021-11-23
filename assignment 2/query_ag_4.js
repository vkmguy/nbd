printjson(db.people.aggregate([
{ $addFields:
  {
    bmi:
    {
      $divide: [{$toDouble: "$height" },{$multiply: [{$toDouble: "$weight"}, {$toDouble:"$weight"}]}]
    }
  }
},
{
  $group:
  {
  _id: "$nationality",
  avg_bmi: {$avg: "$bmi"},
  min_bmi: {$min: "$bmi"},
  max_bmi: {$max: "$bmi"}
  }
}
]))