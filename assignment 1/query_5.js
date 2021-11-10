printjson(db.people.find({
$expr:{$gt: [{$toDate: "$birth_date"}, 2000]}},
{
   "first_name": 1,
   "last_name": 1,
   "location.city":1
}
).toArray())