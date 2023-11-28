import speech_recognition as sr
import playaudio as pa

recognizer = sr.Recognizer()
source = sr.Microphone()

while True:
    print("Speak")
    pa.playaudio("intro.wav")
    audio = recognizer.listen(source)
    text = recognizer.recognize_google(audio)
    repr(text)
    break




