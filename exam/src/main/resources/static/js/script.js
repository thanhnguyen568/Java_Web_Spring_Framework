function selects() {
    let row = document.getElementsByName('checkbox');
    let check = document.getElementById("check")
    if (check.checked === true) {
        for (let i = 0; i < row.length; i++) {
            if (row[i].type === 'checkbox')
                row[i].checked = true;
        }
    } else {
        for (let i = 0; i < row.length; i++) {
            if (row[i].type === 'checkbox')
                row[i].checked = false;
        }
    }
}
