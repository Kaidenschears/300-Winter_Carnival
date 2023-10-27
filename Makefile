# Define the Java compiler
JAVAC = javac

# Define the Java runtime
JAVA = java

# Define the location of your .jar file
JAR_FILE = P05.jar

# Define the source file(s) for your Java program
SOURCE_FILES = FrozenStatue.java StarshipRobot.java DancingBadger.java WinterCarnival.java

# Define the classpath, including the .jar file
CLASSPATH = .:$(JAR_FILE)

# Define the target executable
TARGET = WinterCarnival

# Define the default target to build and run the program
all: $(TARGET)

# Build the Java program
$(TARGET): $(SOURCE_FILES)
	$(JAVAC) -cp $(CLASSPATH) $(SOURCE_FILES)

# Run the Java program
run: $(TARGET)
	$(JAVA) -cp $(CLASSPATH) $(TARGET)

# Clean the generated .class files
clean:
	rm -f *.class