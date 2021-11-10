printjson(db.people.insertOne(
   {
    sex: 'Male',
    first_name: 'Vikram',
    last_name: 'Mandal',
    job: 'Programmer IV',
    email: 'mandalv@pjwstk.com',
    location: {
      city: 'Warsaw',
      address: { streetname: 'Milwaukee', streetnumber: '59' }
    },
    description: 'Software developer',
    height: '180',
    weight: '85',
    birth_date: '1993-01-24T18:44:26Z',
    nationality: 'Indian',
    credit: [
      {
        type: 'jcb',
        number: '3533442768305884',
        currency: 'YER',
        balance: '4875.81'
      },
      {
        type: 'diners-club-enroute',
        number: '560224337801149807',
        currency: 'BRL',
        balance: '4951.83'
      }
    ]
  }
))