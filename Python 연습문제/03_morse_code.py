#2017-12-28

morse_code = {
    '.-':'A', '-...':'B', '-.-.':'C', '-..':'D', '.':'E', '..-.':'F', '--.':'G',
    '....':'H', '..':'I', '.---':'J', '-.-':'K', '.-..':'L', '--':'M',
    '-.':'N', '---':'O', '.--.':'P', '--.-':'Q', '.-.':'R', '...':'S',
    '-':'T', '..-':'U', '...-':'V', '.--':'W', '-..-':'X', '-.--':'Y', '--..':'Z'
}

def interpret_morse(code):
    words = code.split("  ")
    new_chars = []
    text = ""
    for item in words:
        new_chars = str(item).split()
        for char in new_chars:
            text += morse_code[char]
        text += " "
    return text

print(interpret_morse(".... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--"))