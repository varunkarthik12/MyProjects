from email import message
from os import system

from dotenv import load_dotenv
import streamlit as st
from langchain_groq import ChatGroq
import strparser

#load_dotenv()
GROQ_API_KEY = st.secrets.get("GROQ_API_KEY", os.getenv("GROQ_API_KEY"))

st.title("💬 Generative AI Chat Bot")

if "chat_history" not in st.session_state:
    st.session_state.chat_history = []
    st.session_state.chat_history.append(

            {"role": "system",
            "content": "You are a chat Assistant system who answers to the point for an Engineer"}

    )

for message in st.session_state.chat_history:
    if(message["role"] == "system"):
        continue
    with st.chat_message(message["role"]):
        st.markdown(message["content"]);

llm = ChatGroq(
    model = "openai/gpt-oss-20b",
    temperature = 0.0,
    api_key=GROQ_API_KEY
)

user_prompt:str = st.chat_input("Ask ChatBot......");

if user_prompt:
    with st.chat_message("user"):
        st.markdown(user_prompt)
    st.session_state.chat_history.append(
        {"role":"user" , "content":user_prompt} )
    response = llm.invoke(
        st.session_state.chat_history
    )
    with st.chat_message("assistant"):
        st.markdown(response.content)
    st.session_state.chat_history.append(
        {"role":"assistant" ,"content":response.content}
    )





