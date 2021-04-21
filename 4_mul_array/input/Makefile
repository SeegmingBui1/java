
CC = gcc

CPPFLAGS = -I. -I/opt/jdk1.8.0_121/include/ -I/opt/jdk1.8.0_121/include/linux/

TARGET ?= libckey.so

FILES = Kyo

LIBS = $(FILES).class $(FILES).o

.PHONY: TARGET

all: $(TARGET)

$(TARGET):$(LIBS)
	$(CC) -shared $(FILES).o -o $@

%.class:%.java
	javac $<
	javah $(FILES)

%.o:%.c
	$(CC) -c $< -o $@ $(CPPFLAGS) -fPIC

clean:
	rm *.o *.class $(TARGET) -f

install:
	sudo /bin/cp $(TARGET) /usr/lib/

uninstall:
	sudo rm /usr/lib/$(TARGET) -f

