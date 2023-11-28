import speech_recognition as sr
# Crearea unui obiect Recognizer
recognizer = sr.Recognizer()

# Înregistrarea unui mesaj vocal de la un microfon
with sr.Microphone() as source:
    print("Spuneți ceva:")
    audio = recognizer.listen(source)

# Utilizarea motorului de recunoaștere vocală Google pentru a converti vorbirea în text
try:

    text = recognizer.recognize_google(audio)
    print("Ați spus: " + text)
    
except sr.UnknownValueError:
    print("Nu am putut recunoaște vorbirea.")
except sr.RequestError as e:
    print("Eroare la cererea de recunoaștere vocală; {0}".format(e))
