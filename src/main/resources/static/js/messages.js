export function getNotificationElement() {
    return `<div id="noticeBox"></div>`
}

export function showNotification(messageText, messageType) {
    //TODO: see if you can use an enum for message type

    let nB = $("#noticeBox");
    nB.hide();
    nB.removeClass()
    nB.addClass("alert")
    nB.addClass("alert-" + messageType)
    nB.text(messageText);
    nB.slideDown(1000).delay(1000).slideUp(1000);

}