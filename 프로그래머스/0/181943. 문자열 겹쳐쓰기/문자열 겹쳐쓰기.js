function solution(my_string, overwrite_string, s) {
    const my_str = [...my_string]
    my_str.splice(s, overwrite_string.length, overwrite_string)
    return my_str.join("")
}