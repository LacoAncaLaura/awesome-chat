window.Chat = {

    API_URL: "http://localhost:8088",

    createChats: function () {

        $.ajax({
            url: Chat.API_URL + "/chats",
            method: "POST",
        }).done(function (response) {

            console.log(response)

        })
    }
};
Chat.createChats();