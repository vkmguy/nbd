printjson(db.people.find({ $and:[
{$expr: {$gt:[{ $toDouble: "$weight" }, 68]}},
{$expr: {$lt: [{ $toDouble: "$weight" }, 71.5 ]}}
]}).toArray())