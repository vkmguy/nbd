printjson(db.people.aggregate([
{ $group: 
	{ _id: { sex: "$sex" }, 
	avgHeight: { $avg: { $toDouble: "$height" } }, 
	avgWeight: { $avg: { $toDouble: "$weight" } } 
	} 
}]))