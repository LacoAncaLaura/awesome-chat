window.Chat = {

    API_URL: "http://localhost:8088",

    getChats: function () {

        $.ajax({
            method: "GET",
            url: Chat.API_URL + "/chats"
        }).done(function (response) {

            console.log(response)

        })
    }
};
Chat.getChats();