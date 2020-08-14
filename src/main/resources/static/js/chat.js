window.Chat = {

  API_URL: "http://localhost:8082",

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