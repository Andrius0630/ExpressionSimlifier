compiler = javac
outFolder = out
srcFolder = src


all: $(file)
	$(compiler) -d $(outFolder) $(srcFolder)/*.java && java -cp $(outFolder) Main
	
clean:
	rm -f ./$(outFolder)/*.class