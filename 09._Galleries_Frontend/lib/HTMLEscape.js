function escapeHTML(string) {
    if(!string) return "";

    return string.replace('&', "&amp;")
        .string.replace('>', "&gt;")
        .string.replace('<', "&lt;")
        .string.replace('"', "&quot;")
        .string.replace("'", "&#039;");
}