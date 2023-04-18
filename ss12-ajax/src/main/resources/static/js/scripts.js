function search() {
    let search = $(".search").val();
    // let search = "ss";
    $.ajax({
        url: "http://localhost:8080/api/blogs/search",
        data: {
            search: search,
        },
        type: "get",
        dataType: "json",
        success: function (res) {
            let result = "";
            for (let i = 0; i < res.length; i++) {
                result +=
                    `
                    <tr>
                        <td>${res[i].blogNo}</td>
                        <td>${res[i].title}</td>
                        <td>${res[i].description}</td>
                        <td>${res[i].type.typeName}</td>
                    </tr>
                    `
            }
            $("#result").html(result);
        }
    })
}

function addLine() {
    $.ajax({
        url: "http://localhost:8080/api/blogs",
        data: {
            search: search,
        },
        type: "post",
        dataType: "json",
        success: function (res) {
            let result = "";
            for (let i = 0; i < res.length; i++) {
                result +=
                    `
                    <tr>
                        <td>${res[i].blogNo}</td>
                        <td>${res[i].title}</td>
                        <td>${res[i].description}</td>
                        <td>${res[i].type.typeName}</td>
                    </tr>
                    `
            }
            $("#result").html(result);
        }
    })
}