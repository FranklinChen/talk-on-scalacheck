# Use Beamer for slides, Minted for code highlighting.
# Minted requires Pygments: http://pygments.org/ 
PDFLATEX = pdflatex

all:	slides.pdf

slides.pdf:	slides.tex
	$(PDFLATEX) -shell-escape $^

.PHONY:	all
