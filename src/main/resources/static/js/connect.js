window.User = {

    API_URL: "http://localhost:8088",

    createUser: function () {

        $.ajax({
            url: User.API_URL + "/users",
            method: "POST",
            data: JSON.stringify({
                "name": "George",
                "age": 18,
                "gender": "male"
            })
        }).done(function (response) {
            console.log(response)

        })
    }
},
User.createUser();