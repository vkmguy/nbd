printjson(db.people.aggregate([
{$match: {
  sex: "Female",
  nationality: "Poland"
}
},
{ $unwind: {
  path: "$credit"
}
},
{
  $group:{
  _id: "$credit.currency",
  averageMoney: {$avg: {$toDouble:"$credit.balance"}},
  totatMoney: {$sum: {$toDouble: "$credit.balance"}}
}
}
]))