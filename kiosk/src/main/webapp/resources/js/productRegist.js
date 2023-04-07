function setThumbnail(event) {
    let reader = new FileReader();
    reader.onload = function(event) {
        let img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        $("#preview_img").html(img)
    };
    reader.readAsDataURL(event.target.files[0]);
}


