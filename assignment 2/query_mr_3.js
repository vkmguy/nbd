var mapJobs = function(){
    emit(this.job, 1);
};

var reduceJobs = function(job, value){
  count = 0;
  for(i=0;i<value.length;i++){
    count++;
  }
  return count;
};

db.people.mapReduce(
mapJobs,
reduceJobs,
{
  out: 'unique_jobs',
}
)
printjson(db.unique_jobs.find().toArray())

