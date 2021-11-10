printjson(db.people.deleteMany({
$expr:{$gt: [{$toDouble: "$height"}, 190]}
}))