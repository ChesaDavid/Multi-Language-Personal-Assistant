import speech_recognition as sr
from googletrans import Translator as Translator
from textblob import TextBlob

translator = Translator()
recognizer = sr.Recognizer()

def transalte1(tx):
     translation=translator.translate(tx,dest='en')
     print(translation)
     return translation

def functionimportant(lang,tx):
     if lang == 'en':
         print(tx)
         return tx
     else: 
      transalte1(tx)

with sr.Microphone() as source:
    audio = recognizer.listen(source)
try:
    text = recognizer.recognize_google_cloud(audio)
    leng=TextBlob(text)
    functionimportant(leng,text)
except sr.UnknownValueError:
    print("Eror Unknown Value")
except sr.RequestError as e:
    print("Request erorr")